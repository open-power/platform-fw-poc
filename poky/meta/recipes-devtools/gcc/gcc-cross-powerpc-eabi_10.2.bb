# Copyright (C) 2025 Unknown User <kokilavaradhan@gmail.com>
# Released under the MIT license (see COPYING.MIT for the terms)
SUMMARY = "GCC cross-compiler for PowerPC EABI (PPE42)"
LICENSE = "GPL-3.0-with-GCC-exception"
LIC_FILES_CHKSUM = "file://COPYING;md5=98249b9776d66e067283a330f89adcc2"

require recipes-devtools/gcc/gcc-cross.inc

DEPENDS = "virtual/${TARGET_PREFIX}binutils gmp-native mpfr-native mpc-native"

PN = "gcc-cross-powerpc-eabi"
TARGET_SYS = "powerpc-eabi"

PROVIDES += "virtual/${TARGET_SYS}-gcc"

EXTRA_OECONF = " \
    --target=${TARGET_SYS} \
    --without-headers \
    --with-newlib \
    --with-gnu-as \
    --with-gnu-ld \
    --enable-languages=c,c++ \
    --disable-libssp \
    --disable-nls \
    --disable-multilib \
    --with-sysroot=${STAGING_DIR_TARGET} \
"

FILES:${PN} += "${libdir}/* ${base_libdir}/*"

INSANE_SKIP:${PN} = "arch"

