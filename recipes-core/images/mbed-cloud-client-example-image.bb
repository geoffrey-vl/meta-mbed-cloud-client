# Base this image on mbed-cloud-client-example
include recipes-core/users_and_security/general-security.bb
# Include image recipe for HW configurations
include recipes-core/images/mbed-cloud-console-image.bb

LICENSE = "Apache-2.0"

# Include modules in rootfs
IMAGE_INSTALL += " \
	mbed-cloud-client\
	update-scripts"
