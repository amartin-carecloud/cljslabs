(ns houseofliars.state
  (:require [reagent.core :as reagent :refer [atom]]
            [houseofliars.api :as api]))

(def initial-app-state {:candidates []
                        :score {:right 0
                                :wrong 0}
                        :quotes []
                        :asked []
                        :tracker {}
                        :game-title "HOUSE OF LIARS"
                        :animate {1 {:toggle false
                                     :animate "shake"}
                                  2 {:toggle false
                                     :animate "tada"}
                                  3 {:toggle false
                                     :animate "bounce"}
                                  4 {:toggle false
                                     :animate "jello"}
                                  5 {:toggle false
                                     :animate "swing"}}
                        :max-questions 10})

(def app-state (atom initial-app-state))

(defn candidate-success-handler
  "Handler fn passed to ajax call. Adds the candidates to the app-state"
  [data]

  ;; Uncomment below and add your code
  ;;(swap! app-state assoc-in [:candidates] data )
  )

(defn quotes-success-handler
  "Handler fn passed to ajax call. Shuffles the quotes and adds them to the app-state"
  [data]

  ;;Uncomment below and add your code
  ;;(swap! app-state assoc-in [:quotes] data))
  )

(defn initialize-app-state!
  "Populates the app-state on load"
  []
  (api/get-resource api/api-candidates-url candidate-success-handler)
  (api/get-resource api/api-quotes-url quotes-success-handler))

(defn reset-app-state!
  "Resets the app-state"
  []
  (swap! app-state merge initial-app-state)
  (initialize-app-state!))
