(declare-fun a_0 () Int)
(declare-fun return () Int)
(assert (= return (* a_0 a_0)))
(assert (not (> 0 return)))
(check-sat)
(get-model)