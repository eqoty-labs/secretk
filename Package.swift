// swift-tools-version:5.3
import PackageDescription

let package = Package(
    name: "secretk",
    platforms: [
        .iOS(.v13),
.macOS(.v13)
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
