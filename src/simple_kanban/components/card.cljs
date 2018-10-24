(ns simple-kanban.components.card
  (:require [simple-kanban.actions :refer [advance-card]]))

(defn card [task current-section-cards button-text next-section-cards]
    ^{:key (get (val task) :id)}
    [:li
     [:b "Task: "] (get (val task) :description)
     [:br]
     [:b "Owner: "] (get (val task) :owner)
     [:br]
     [:button {:class "advance-card-button" :on-click #(advance-card task current-section-cards next-section-cards)}
      button-text]])
