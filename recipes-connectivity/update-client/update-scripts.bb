DESCRIPTION="update-scripts"

LICENSE = "Apache-2.0"
LICENSE_MD5SUM = "4336ad26bb93846e47581adc44c4514d"
SOURCE_REPOSITORY = "https://github.com/ARMmbed/mbed-cloud-client.git"
SOURCE_BRANCH = "master"
SRCREV = "62de4b89d2350379278893f2f7a3ac937b4ae5f6"
SCRIPT_DIR = "${WORKDIR}/git/update-client-hub/modules/pal-linux/scripts"

# Default Update scripts are for Raspberrypi3. Please override these for HW specific srcipts if required.
UPDATE_CMDLINE          ?= "${SCRIPT_DIR}/arm_update_cmdline.sh"
UPDATE_ACTIVATE         ?= "${SCRIPT_DIR}/yocto_rpi/arm_update_activate.sh"
UPDATE_ACTIVATE_DETAILS ?= "${SCRIPT_DIR}/yocto_rpi/arm_update_active_details.sh"

LIC_FILES_CHKSUM = "file://${WORKDIR}/git/LICENSE;md5=${LICENSE_MD5SUM}"

# Patches for quilt goes to files directory
#FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI = "${SOURCE_REPOSITORY};branch=${SOURCE_BRANCH};protocol=ssh"

# Deploy for getting update-client-hub to working area
do_configure() {
    cd "${WORKDIR}/git"
    ${binlocaldir}/mbed deploy --protocol ssh
}

# Install update-scripts
do_install() {
    install -d "${D}/opt/arm"
    install -m 755 "${UPDATE_CMDLINE}"          "${D}/opt/arm"
    install -m 755 "${UPDATE_ACTIVATE}"         "${D}/opt/arm"
    install -m 755 "${UPDATE_ACTIVATE_DETAILS}" "${D}/opt/arm"
}

FILES_${PN} += "/opt \
                /opt/arm"
