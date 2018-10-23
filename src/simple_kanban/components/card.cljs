(ns simple-kanban.components.card
  (:require [simple-kanban.actions :refer [advance-card]]
            [simple-kanban.utils :refer [card-data]]))

(defn render [card current-section-cards button-text next-section-cards]
  ^{:key (card-data card :id)}
  [:li
   [:b "Task: "] (card-data card :description)
   [:br]
   [:b "Owner: "] (card-data card :owner)
   [:br]
   [:button {:class "advance-card-button" :on-click #(advance-card card current-section-cards next-section-cards)}
    button-text]])