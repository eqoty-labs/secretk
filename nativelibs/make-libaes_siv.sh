#!/usr/bin/env bash
# darwin target names come from here: https://github.com/leetal/ios-cmake
if [ $# -eq 0 ]
then
  targets="OS64 SIMULATOR64 SIMULATORARM64 MAC MAC_ARM64"
  echo "No arguments supplied. making defaults: " "$targets"
else
  targets=$*
  echo "Arguments supplied. making: " "$targets"
fi




for target in ${targets}
do    
    # create one build dir per target architecture
    mkdir -p ./libaes_siv_build/"${target}"
    cd ./libaes_siv_build/"${target}" || exit

    case $target in

      "OS64"|"OS64COMBINED"|"SIMULATOR64"|"SIMULATORARM64"|"TVOS"|"TVOSCOMBINED"|"SIMULATOR_TVOS"|"WATCHOS"| \
      "WATCHOSCOMBINED"|"SIMULATOR_WATCHOS"|"MAC"|"MAC_ARM64"|"MAC_CATALYST"|"MAC_CATALYST_ARM64")
        OPENSSL_ROOT_DIR=../../darwinopenssl/iphoneos
        OPENSSL_INCLUDE_DIR=../../darwinopenssl/iphoneos/include
        OPENSSL_CRYPTO_LIBRARY=../../darwinopenssl/iphoneos/lib/libcrypto.a
        cmake . -S../../libaes_siv \
          -DOPENSSL_ROOT_DIR=$OPENSSL_ROOT_DIR \
          -DOPENSSL_CRYPTO_LIBRARY=$OPENSSL_CRYPTO_LIBRARY \
          -DOPENSSL_INCLUDE_DIR=$OPENSSL_INCLUDE_DIR \
          -G Xcode -DCMAKE_TOOLCHAIN_FILE=../../ios-cmake/ios.toolchain.cmake -DPLATFORM=$target
        cmake --build . --target aes_siv_static --config Release \
          -- -DOPENSSL_ROOT_DIR=$OPENSSL_ROOT_DIR \
          -DOPENSSL_CRYPTO_LIBRARY=$OPENSSL_CRYPTO_LIBRARY \
          -DOPENSSL_INCLUDE_DIR=$OPENSSL_INCLUDE_DIR
      ;;
      *)
        cmake . -S../../libaes_siv
        make -j32
      ;;
    esac
    
    #Add -DIOS_PLATFORM=SIMULATOR if you intent to run it there
    cd - || exit
done

