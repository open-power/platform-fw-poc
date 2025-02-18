FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

# Override the GCC version with PPC64LE target
TARGET_ARCH = "powerpc64le"
TARGET_SYS = "${TARGET_ARCH}-linux"

# Extra configuration for PPC64LE
EXTRA_OECONF += "--target=${TARGET_SYS} --enable-languages=c,c++ --disable-multilib --with-system-zlib"

# Ensure GCC is cross-compiled for ppc64le architecture
CFLAGS:append = " -mcpu=powerpc64le -mtune=powerpc64le"

# Additional GCC-specific tweaks for PPC64LE (if necessary)
# Example: setting multilib options or any other specific flag
MULTILIB_OPTIONS = "m64"

