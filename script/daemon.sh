#!/bin/sh
lein run script/run.clj > log/deploy.log 2>&1 &
