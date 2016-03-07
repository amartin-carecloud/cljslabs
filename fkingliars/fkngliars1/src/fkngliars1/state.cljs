(ns fkngliars1.state
  (:require [reagent.core :as reagent :refer [atom]]))

(def app-state (atom {:candidates [{:id 1
                                    :fname "Hillary"
                                    :lname "Clinton"
                                    :party "Democrat"
                                    :head "/img/head-hillary.png"}
                                   {:id 2
                                    :fname "Bernie"
                                    :lname "Sanders"
                                    :party "Democrat"
                                    :head "/img/head-bernie.png"}
                                   {:id 3
                                    :fname "Donald"
                                    :lname "Trump"
                                    :party "Republican"
                                    :head "/img/head-donald.png"}
                                   {:id 4
                                    :fname "Marco"
                                    :lname "Rubio"
                                    :party "Republican"
                                    :head "/img/head-marco.png"}
                                   {:id 5
                                    :fname "Ted"
                                    :lname "Cruz"
                                    :party "Republican"
                                    :head "/img/head-ted.png
"}]
                      :score {:right 0
                              :wrong 0}
                      :quotes [{:id 1
                                :candidate_id 1
                                :quote "Bengahzi was not my fault"}
                               {:id 2
                                :candidate_id 2
                                :quote "Superpacs kill people"}
                               {:id 3
                                :candidate_id 3
                                :quote "I don't have small hands"}
                               {:id 4
                                :candidate_id 4
                                :quote "Florida loves me"}
                               {:id 5
                                :candidate_id 5
                                :quote "Jebus and I are bffs"}
                               ]
                      :asked []
                      :tracker {}}))
