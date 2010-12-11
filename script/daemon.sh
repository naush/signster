#!/bin/sh
#. run.sh > log/deploy.log 2>&1 &
lein run script/run.clj > log/deploy.log 2>&1 &
