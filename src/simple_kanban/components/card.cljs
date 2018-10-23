(ns simple-kanban.components.card
  (:require [simple-kanban.actions :as actions]
            [simple-kanban.utils :as utils]))

(defn render [card cards button-text advance-to]
  ^{:key (utils/card-data card :id)}
  [:li
   [:b "Task: "] (utils/card-data card :description)
   [:br]
   [:b "Owner: "] (utils/card-data card :owner)
   [:br]
   [:button {:class "advance-card-button" :on-click #(actions/advance-card card cards advance-to)}
    button-text]])