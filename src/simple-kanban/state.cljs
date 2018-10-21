(ns simple-kanban.state
  (:require [reagent.core :as r]))

(defonce in-backlog (r/atom {}))
(defonce in-dev (r/atom {}))
(defonce in-test (r/atom {}))
(defonce in-done (r/atom {}))
(defonce new-task-description (r/atom ""))
(defonce new-task-owner (r/atom ""))
(defonce id-counter (r/atom 0))
