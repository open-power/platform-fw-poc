# Copyright (C) 2025 Unknown User <kokilavaradhan@gmail.com>
# Released under the MIT license (see COPYING.MIT for the terms)

SUMMARY = "fsp-trace"
HOMEPAGE = "https://github.com/open-power/fsp-trace"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM ="file://LICENSE;md5=34400b68072d710fecd0a2940a0d1658"
SECTION = "utils"
#DEPENDS = "gcc"
PV = "0.1+git${SRCPV}"
PR = "r1"
SRCREV = "cf0bd9b36c0d8cb091a471973493d1370330c7d1"
SRC_URI = "git://github.com/open-power/fsp-trace;branch=master;protocol=https"
S = "${WORKDIR}/git"
B = "${WORKDIR}/build"
inherit autotools

do_compile() {
    oe_runmake -C ${S} V=1  
    ls -l ${S}  # Check if the binary is created in ${S} after compilation
}
do_install() {
    install -d ${D}${bindir}
    install -m 0755 ${S}/fsp-trace ${D}${bindir}/  # Correct path to fsp-trace binary
}
