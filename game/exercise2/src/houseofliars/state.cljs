(ns houseofliars.state
  (:require [reagent.core :as reagent :refer [atom]]
            [houseofliars.api :as api]))

(def initial-app-state {:candidates [] ;; Populate me
                        :quotes [] ;; Populate me
                        :score {:right 0
                                :wrong 0}
                        :asked []
                        :tracker {}
                        :game-title "HOUSE OF LIARS"
                        :max-questions 5})

(def app-state (atom initial-app-state))

(defn reset-app-state!
  "Resets the app-state"
  []
  (swap! app-state merge initial-app-state))
