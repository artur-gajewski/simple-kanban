(ns simple-kanban.components.done-section
  (:require [simple-kanban.components.card-list :as card-list]
            [simple-kanban.utils :as utils]
            [simple-kanban.state :as state]))

(defn component []
  [:div {:class "section"} [:div {:class "column-header"} (str "Done ( " (count @state/in-done) " )")]
   [card-list/component state/in-done "Archive" nil]])
