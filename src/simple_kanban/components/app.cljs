(ns simple-kanban.components.app
  (:require [simple-kanban.components.section :refer [section]]
            [simple-kanban.state :refer [in-backlog
                                         in-dev
                                         in-test
                                         in-done]]))

(defn app []
  [:div {:class "app"}
   [:h1 {:id "title"} "Simple Kanban"]
   [:div {:class "container"}
    [section "Backlog" "Advance" in-backlog in-dev true false]
    [section "In Development" "Advance" in-dev in-test false true]
    [section "In Testing" "Advance" in-test in-done false false]
    [section "Done" "Archive" in-done nil false false]]])