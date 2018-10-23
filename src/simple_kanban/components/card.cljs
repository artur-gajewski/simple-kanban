(ns simple-kanban.components.card
  (:require [simple-kanban.actions :refer [advance-card]]
            [simple-kanban.utils :refer [card-data]]))

(defn render [card cards button-text advance-to]
  ^{:key (card-data card :id)}
  [:li
   [:b "Task: "] (card-data card :description)
   [:br]
   [:b "Owner: "] (card-data card :owner)
   [:br]
   [:button {:class "advance-card-button" :on-click #(advance-card card cards advance-to)}
    button-text]])