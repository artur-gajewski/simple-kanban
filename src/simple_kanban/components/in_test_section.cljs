(ns simple-kanban.components.in-test-section
  (:require [simple-kanban.components.card-list :as card-list]
            [simple-kanban.utils :as utils]
            [simple-kanban.state :as state]))

(defn component []
  [:div {:class "section"} [:div {:class "column-header"} (str "In Test ( " (count @state/in-test) " )")]
   [card-list/component state/in-test "Advance" state/in-done]])
