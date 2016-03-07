(ns fkngliars1.components.button
  (:require
   [reagent.core :as reagent]
   [fkngliars1.state :as state :refer [app-state]]
   [fkngliars1.components.message :as message]
   [fkngliars1.utils :as utils]))

(defn button-component-did-mount
  [this]
  (js/$
   (fn[]
     (let [$this (js/$ (.getDOMNode this))]       
       (.on $this "click"
            (fn [event]
              (let [$target                      (js/$ (.-target event))
                    candidateId                  (.-candidateId (.data $target))
                    {:keys [candidate_id quote]} (get-in @app-state [:tracker :current-quote])
                    isCorrect?                   (= candidateId candidate_id)]
                (when (<= 1 (count (:quotes @app-state)))
                  (utils/process-turn isCorrect? candidate_id)))))))))

(defn button-component
  [id]
  (reagent/create-class
   {:reagent-render (fn [id]
                      [:button {:className "btn btn-lg default outline liar-button"
                                :data-candidate-id id}
                       "LIAR!"])
    :component-did-mount button-component-did-mount
    }))
