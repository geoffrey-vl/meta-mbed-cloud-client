#!/bin/sh

start() {
  echo "To stop, send SIGTERM or SIGINT to mbedCloudClientExample or unregister client."
  /opt/arm/mbedCloudClientExample.elf < /dev/ttyS0
}

stop() {
  echo "To stop, send SIGTERM or SIGINT to mbedCloudClientExample or unregister client."
}

case "$1" in
  start)
    start
    ;;
  stop)
    stop
    ;;
  *)
    echo "Usage: $0 {start}"
esac

