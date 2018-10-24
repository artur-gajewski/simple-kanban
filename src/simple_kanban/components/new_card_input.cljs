(ns simple-kanban.components.new-card-input
  (:require [simple-kanban.actions :refer [add-card-to-backlog]]
            [simple-kanban.state :refer [new-task-description
                                         new-task-owner]]))

(defn new-card-input []
  [:div
   [:input {:type "text"
            :value @new-task-description
            :on-change #(reset! new-task-description (-> % .-target .-value))
            :placeholder "Description..."
            :autoFocus true}]
   [:input {:type "text"
            :value @new-task-owner
            :on-change #(reset! new-task-owner (-> % .-target .-value))
            :placeholder "Owner..."}]
   [:button {:class "create-card-button"
             :on-click #(add-card-to-backlog @new-task-description @new-task-owner)
             :disabled
             (or
              (= (count @new-task-description) 0)
              (= (count @new-task-owner) 0))} "Add new task"]])
