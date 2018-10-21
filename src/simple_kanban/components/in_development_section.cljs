(ns simple-kanban.components.in-development-section
  (:require [simple-kanban.components.card-list :as card-list]
            [simple-kanban.utils :as utils]
            [simple-kanban.state :as state]))

(defn component []
  [:div {:class "section"} [:div {:class "column-header"} (str "In Development ( " (count @state/in-dev) " )")]
   [card-list/component state/in-dev "Advance" state/in-test]])
