(ns houseofliars.state
  (:require [reagent.core :as reagent :refer [atom]]))

;; The empty map
(def app-state (atom {}))

(defn reset-app-state!
  "Resets the app-state"
  []
  (swap! app-state {}))
