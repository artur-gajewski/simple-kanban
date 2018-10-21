(ns simple-kanban.core
  (:require [reagent.core :as reagent]
            [simple-kanban.components.app :as app]
            [simple-kanban.utils :as utils]
            [simple-kanban.state :as state]))

(defn mount-root []
  (reagent/render [app/component] (.getElementById js/document "app")))

(defn init! []
  (mount-root))
