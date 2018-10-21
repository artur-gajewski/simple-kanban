(ns simple-kanban.utils)

(defn card-data [card key]
  (get (val card) key))
