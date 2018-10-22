(ns simple-kanban.components.card-list
  (:require
   [simple-kanban.components.card :as card]))

(defn component [cards button-text advance-to]
  [:ul
   (for [card @cards]
     (card/component card cards button-text advance-to))])
