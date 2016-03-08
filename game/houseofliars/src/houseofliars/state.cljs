(ns houseofliars.state
  (:require [reagent.core :as reagent :refer [atom]]
            [houseofliars.api :as api]))

(def blank-app-state {:candidates []
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
                      :max-questions 5})

(def app-state (atom blank-app-state))

(defn candidate-success-handler
  "Handler fn passed to ajax call. Adds the candidates to the app-state"
  [data]
  (swap! app-state assoc-in [:candidates] (js->clj data :keywordize-keys true)))

(defn quotes-success-handler
  "Handler fn passed to ajax call. Shuffles the quotes and them to the app-state"
  [data]
  (swap! app-state assoc-in [:quotes] (shuffle (js->clj data :keywordize-keys true))))

(defn initialize-app-state!
  "Populates the app-state on load"
  []
  (api/get-resource api/api-candidates-url candidate-success-handler)
  (api/get-resource api/api-quotes-url quotes-success-handler))

(defn reset-app-state!
  "Resets the app-state"
  []
  (swap! app-state merge blank-app-state)
  (initialize-app-state!))
