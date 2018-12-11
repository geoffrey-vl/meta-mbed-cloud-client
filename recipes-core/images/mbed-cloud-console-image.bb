# Base this image on console-image
include recipes-core/images/console-image.bb
inherit core-image

LICENSE = "Apache-2.0"


# Include modules in rootfs
IMAGE_INSTALL += " \
	ldd \
	u-boot-fw-utils \
	logrotate \
	util-linux-agetty \
	util-linux \
	rng-tools \
	e2fsprogs"

export IMAGE_BASENAME = "mbed-cloud-console-image"
