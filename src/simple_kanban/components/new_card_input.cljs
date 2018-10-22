(ns simple-kanban.components.new-card-input
  (:require [simple-kanban.actions :as actions]
            [simple-kanban.utils :as utils]
            [simple-kanban.state :as state]))

(defn component []
  [:div
   [:input {:type "text"
            :value @state/new-task-description
            :on-change #(state/on-change state/new-task-description %)
            :placeholder "Description..."
            :autoFocus true}]
   [:input {:type "text"
            :value @state/new-task-owner
            :on-change #(state/on-change state/new-task-owner %)
            :placeholder "Owner..."}]
   [:button {:class "create-card-button"
             :on-click #(actions/add-card-to-backlog @state/new-task-description @state/new-task-owner)
             :disabled
             (or
              (= (count @state/new-task-description) 0)
              (= (count @state/new-task-owner) 0))} "Add new task"]])
