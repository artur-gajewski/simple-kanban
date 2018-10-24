(ns simple-kanban.components.card-list
  (:require [simple-kanban.components.card :refer [card]]))

(defn card-list [current-section-cards button-text next-section-cards]
  [:ul
   (for [task @current-section-cards]
     (card task current-section-cards button-text next-section-cards))])
