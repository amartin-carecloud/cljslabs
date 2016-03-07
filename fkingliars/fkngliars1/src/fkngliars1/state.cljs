(ns fkngliars1.state
  (:require [reagent.core :as reagent :refer [atom]]
            [fkngliars1.api :as api]))

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
                                   :animate "swing"}}})

(def app-state (atom blank-app-state))

(defn candidate-success-handler
  [data]
  (swap! app-state assoc-in [:candidates] (js->clj data :keywordize-keys true)))

(defn quotes-success-handler
  [data]
  (swap! app-state assoc-in [:quotes] (shuffle (js->clj data :keywordize-keys true))))

(defn initialize-app-state!
  []
  (api/get-resource api/api-candidates-url candidate-success-handler)
  (api/get-resource api/api-quotes-url quotes-success-handler))

(defn reset-app-state!
  []
  (swap! app-state merge blank-app-state)
  (initialize-app-state!))
