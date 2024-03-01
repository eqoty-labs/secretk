// swift-tools-version:6.0
import PackageDescription

let package = Package(
    name: "secretk",
    platforms: [
        .iOS(.v13),
.macOS(.v10_11),
.tvOS(.v9)
    ],
    products: [
        .library(
            name: "secretk",
            targets: ["secretk"]
        ),
    ],
    targets: [
        .binaryTarget(
            name: "secretk",
            path: "./secretk.xcframework"
        ),
    ]
)
