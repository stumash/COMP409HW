#!/usr/bin/env bash

THIS_DIR=$(dirname $(readlink -f "${BASH_SOURCE[0]}"))
cd "${THIS_DIR}"

cd target/classes

java Main "${@}"
