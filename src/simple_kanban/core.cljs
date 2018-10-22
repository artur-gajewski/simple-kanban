(ns simple-kanban.core
  (:require [reagent.core :as reagent]
            [simple-kanban.components.app :as app]))

(defn mount-root []
  (reagent/render [app/component] (.getElementById js/document "app")))

(defn init! []
  (mount-root))
