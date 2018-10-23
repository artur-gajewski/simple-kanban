(ns simple-kanban.components.card-list
  (:require
   [simple-kanban.components.card :as card]))

(defn render [current-section-cards button-text next-section-cards]
  [:ul
   (for [card @current-section-cards]
     [card/render card current-section-cards button-text next-section-cards])])
