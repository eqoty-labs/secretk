package jslib.walletconnectv2.web3modal

import jslib.es5.Omit

typealias Web3ModalConfig = Omit<ConfigCtrlState, String /* "enableStandaloneMode" */>
