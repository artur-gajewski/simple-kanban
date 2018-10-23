(ns simple-kanban.components.card-list
  (:require
   [simple-kanban.components.card :as card]))

(defn render [cards button-text advance-to]
  [:ul
   (for [card @cards]
     [card/render card cards button-text advance-to])])
