#!/bin/zsh
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

      "OS64"|"OS64COMBINED")
        OPENSSL_ROOT_DIR=../../darwinopenssl/iphoneos
        OPENSSL_INCLUDE_DIR=../../darwinopenssl/iphoneos/include
        OPENSSL_CRYPTO_LIBRARY=../../darwinopenssl/iphoneos/lib/libcrypto.a
        ;&
      "SIMULATOR64"|"SIMULATORARM64")
        OPENSSL_ROOT_DIR=../../darwinopenssl/iphonesimulator
        OPENSSL_INCLUDE_DIR=../../darwinopenssl/iphonesimulator/include
        OPENSSL_CRYPTO_LIBRARY=../../darwinopenssl/iphonesimulator/lib/libcrypto.a
        ;&
      "MAC"|"MAC_ARM64")
        OPENSSL_ROOT_DIR=../../darwinopenssl/macosx
        OPENSSL_INCLUDE_DIR=../../darwinopenssl/macosx/include
        OPENSSL_CRYPTO_LIBRARY=../../darwinopenssl/macosx/lib/libcrypto.a
        ;&
      "MAC_CATALYST"|"MAC_CATALYST_ARM64")
        OPENSSL_ROOT_DIR=../../darwinopenssl/macosx_catalyst
        OPENSSL_INCLUDE_DIR=../../darwinopenssl/macosx_catalyst/include
        OPENSSL_CRYPTO_LIBRARY=../../darwinopenssl/macosx_catalyst/lib/libcrypto.a
        ;&
      "OS64"|"OS64COMBINED"|"SIMULATOR64"|"SIMULATORARM64"|"MAC"|"MAC_ARM64"|"MAC_CATALYST"|"MAC_CATALYST_ARM64")
        DEPLOYMENT_TARGET=13.0
        cmake -S../../libaes_siv \
          -DOPENSSL_ROOT_DIR=$OPENSSL_ROOT_DIR \
          -DOPENSSL_CRYPTO_LIBRARY=$OPENSSL_CRYPTO_LIBRARY \
          -DOPENSSL_INCLUDE_DIR=$OPENSSL_INCLUDE_DIR \
          -G Xcode -DCMAKE_TOOLCHAIN_FILE=../../ios-cmake/ios.toolchain.cmake \
          -DPLATFORM="$target" -DDEPLOYMENT_TARGET=DEPLOYMENT_TARGET
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

