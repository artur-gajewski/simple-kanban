(ns simple-kanban.core
  (:require [reagent.core :as reagent]
            [simple-kanban.utils :as utils]
            [simple-kanban.state :as state]))

;; -------------------------
;; Actions

(defn reset-inputs []
  (reset! state/new-task-description "")
  (reset! state/new-task-owner ""))

(defn remove-card [id cards]
  (swap! cards dissoc id))

(defn advance-card [card cards destination]
  (if (nil? destination) (remove-card (utils/card-data card :id) cards))
  (let [id (utils/card-data card :id)
        task (utils/card-data card :task)
        completed (utils/card-data card :completed)
        owner (utils/card-data card :owner)]
    (swap! destination assoc id {:id id :task task :completed completed :owner owner}))
  (remove-card (utils/card-data card :id) cards))

(defn add-card-to-backlog [task owner]
  (let [id (swap!
            state/id-counter inc)]
    (swap! state/in-backlog assoc id {:id id :task task :completed false :owner owner}))
  (reset-inputs))

;; -------------------------
;; Components

(defn new-card-input-component []
  [:div [:input {:type "text"
                 :value @state/new-task-description
                 :on-change #(reset! state/new-task-description (-> % .-target .-value))
                 :placeholder "Description..."
                 :autoFocus true}]
   [:input {:type "text"
            :value @state/new-task-owner
            :on-change #(reset! state/new-task-owner (-> % .-target .-value))
            :placeholder "Owner..."}]
   [:button {:class "create-card-button" :on-click #(add-card-to-backlog @state/new-task-description @state/new-task-owner)
             :disabled
             (or
              (= (count @state/new-task-description) 0)
              (= (count @state/new-task-owner) 0))} "Add new task"]])

(defn card-component [card cards button-text advance-to]
  ^{:key card}
  [:li "Task: " (utils/card-data card :task) [:br] " Owner: " (utils/card-data card :owner)
   [:br]
   [:button {:class "advance-card-button" :on-click #(advance-card card cards advance-to)}
    button-text]])

(defn card-list-component [cards button-text advance-to]
  [:ul
   (for [card @cards]
     (card-component card cards button-text advance-to))])

(defn backlog-section-component []
  [:div {:class "section"} [:div {:class "column-header"} (str "Backlog ( " (count @state/in-backlog) " )")]
   [new-card-input-component]
   [card-list-component state/in-backlog "Advance" state/in-dev]])

(defn in-development-section-component []
  [:div {:class "section"} [:div {:class "column-header"} (str "In Development ( " (count @state/in-dev) " )")]
   [card-list-component state/in-dev "Advance" state/in-test]])

(defn in-test-section-component []
  [:div {:class "section"} [:div {:class "column-header"} (str "In Test ( " (count @state/in-test) " )")]
   [card-list-component state/in-test "Advance" state/in-done]])

(defn done-section-component []
  [:div {:class "section"} [:div {:class "column-header"} (str "Done ( " (count @state/in-done) " )")]
   [card-list-component state/in-done "Archive" nil]])

(defn app []
  [:div {:class "app"}
   [:h1 {:id "title"} "Simple Kanban"]
   [:div {:class "container"}
    [backlog-section-component]
    [in-development-section-component]
    [in-test-section-component]
    [done-section-component]]])

;; -------------------------
;; Initialize app

(defn mount-root []
  (reagent/render [app] (.getElementById js/document "app")))

(defn init! []
  (mount-root))
