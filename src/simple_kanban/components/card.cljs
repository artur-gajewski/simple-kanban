(ns simple-kanban.components.card
  (:require [simple-kanban.actions :as actions]
            [simple-kanban.utils :as utils]
            [simple-kanban.state :as state]))

(defn component [card cards button-text advance-to]
  ^{:key card}
  [:li "Task: " (utils/card-data card :task) [:br] " Owner: " (utils/card-data card :owner)
   [:br]
   [:button {:class "advance-card-button" :on-click #(actions/advance-card card cards advance-to)}
    button-text]])