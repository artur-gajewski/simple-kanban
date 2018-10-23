(ns simple-kanban.state
  (:require [reagent.core :as reagent]))

(defonce id-counter (reagent/atom 0))

(defonce new-task-description (reagent/atom ""))

(defonce new-task-owner (reagent/atom ""))

(defonce in-backlog (reagent/atom {}))

(defonce in-dev (reagent/atom {}))

(defonce in-test (reagent/atom {}))

(defonce in-done (reagent/atom {}))

