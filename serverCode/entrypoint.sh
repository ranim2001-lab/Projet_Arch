#!/bin/bash
rmiregistry &
sleep 2
java -cp . server.Server