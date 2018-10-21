(ns simple-kanban.components.app
  (:require [simple-kanban.components.backlog-section :as backlog-section]
            [simple-kanban.components.in-development-section :as in-development-section]
            [simple-kanban.components.in-test-section :as in-test-section]
            [simple-kanban.components.done-section :as done-section]))

(defn component []
  [:div {:class "app"}
   [:h1 {:id "title"} "Simple Kanban"]
   [:div {:class "container"}
    (backlog-section/component)
    (in-development-section/component)
    (in-test-section/component)
    (done-section/component)]])
