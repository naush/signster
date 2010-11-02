(use 'ring.adapter.jetty)
(require 'signster.core)

(run-jetty #'signster.core/app {:port 9001})