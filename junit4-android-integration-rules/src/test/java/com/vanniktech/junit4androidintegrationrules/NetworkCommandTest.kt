package com.vanniktech.junit4androidintegrationrules

import com.vanniktech.junit4androidintegrationrules.NetworkCommand.Companion.network
import com.vanniktech.junit4androidintegrationrules.NetworkCommand.MobileDataType
import com.vanniktech.junit4androidintegrationrules.NetworkCommand.MobileDataType.MOBILE_DATA_TYPE_1X
import com.vanniktech.junit4androidintegrationrules.NetworkCommand.MobileDataType.MOBILE_DATA_TYPE_3G
import com.vanniktech.junit4androidintegrationrules.NetworkCommand.MobileDataType.MOBILE_DATA_TYPE_4G
import com.vanniktech.junit4androidintegrationrules.NetworkCommand.MobileDataType.MOBILE_DATA_TYPE_E
import com.vanniktech.junit4androidintegrationrules.NetworkCommand.MobileDataType.MOBILE_DATA_TYPE_G
import com.vanniktech.junit4androidintegrationrules.NetworkCommand.MobileDataType.MOBILE_DATA_TYPE_H
import com.vanniktech.junit4androidintegrationrules.NetworkCommand.MobileDataType.MOBILE_DATA_TYPE_HIDDEN
import com.vanniktech.junit4androidintegrationrules.NetworkCommand.MobileDataType.MOBILE_DATA_TYPE_LTE
import com.vanniktech.junit4androidintegrationrules.NetworkCommand.MobileDataType.MOBILE_DATA_TYPE_ROAM
import com.vanniktech.junit4androidintegrationrules.NetworkCommand.MobileLevel
import com.vanniktech.junit4androidintegrationrules.NetworkCommand.MobileLevel.MOBILE_LEVEL_0
import com.vanniktech.junit4androidintegrationrules.NetworkCommand.MobileLevel.MOBILE_LEVEL_1
import com.vanniktech.junit4androidintegrationrules.NetworkCommand.MobileLevel.MOBILE_LEVEL_2
import com.vanniktech.junit4androidintegrationrules.NetworkCommand.MobileLevel.MOBILE_LEVEL_3
import com.vanniktech.junit4androidintegrationrules.NetworkCommand.MobileLevel.MOBILE_LEVEL_4
import com.vanniktech.junit4androidintegrationrules.NetworkCommand.MobileLevel.MOBILE_LEVEL_NULL
import com.vanniktech.junit4androidintegrationrules.NetworkCommand.WifiLevel
import com.vanniktech.junit4androidintegrationrules.NetworkCommand.WifiLevel.WIFI_LEVEL_0
import com.vanniktech.junit4androidintegrationrules.NetworkCommand.WifiLevel.WIFI_LEVEL_1
import com.vanniktech.junit4androidintegrationrules.NetworkCommand.WifiLevel.WIFI_LEVEL_2
import com.vanniktech.junit4androidintegrationrules.NetworkCommand.WifiLevel.WIFI_LEVEL_3
import com.vanniktech.junit4androidintegrationrules.NetworkCommand.WifiLevel.WIFI_LEVEL_4
import com.vanniktech.junit4androidintegrationrules.NetworkCommand.WifiLevel.WIFI_LEVEL_NULL
import org.assertj.core.api.Java6Assertions.assertThat
import org.junit.Test

class NetworkCommandTest {
  @Test fun name() {
    assertThat(network().name).isEqualTo("network")
  }

  @Test fun empty() {
    assertThat(network().asCommand()).isEmpty()
  }

  @Test fun airplane() {
    assertThat(network().airplane(true).asCommand()).isEqualTo(" -e airplane show")
    assertThat(network().airplane(false).asCommand()).isEqualTo(" -e airplane false")
  }

  @Test fun fully() {
    assertThat(network().fully(true).asCommand()).isEqualTo(" -e fully true")
    assertThat(network().fully(false).asCommand()).isEqualTo(" -e fully false")
  }

  @Test fun wifi() {
    assertThat(network().wifi(true).asCommand()).isEqualTo(" -e wifi show")
    assertThat(network().wifi(false).asCommand()).isEqualTo(" -e wifi false")
  }

  @Test fun wifiLevel() {
    assertThat(network().wifiLevel(WIFI_LEVEL_NULL).asCommand()).isEqualTo(" -e wifi show -e level null")
    assertThat(network().wifiLevel(WIFI_LEVEL_0).asCommand()).isEqualTo(" -e wifi show -e level 0")
    assertThat(network().wifiLevel(WIFI_LEVEL_1).asCommand()).isEqualTo(" -e wifi show -e level 1")
    assertThat(network().wifiLevel(WIFI_LEVEL_2).asCommand()).isEqualTo(" -e wifi show -e level 2")
    assertThat(network().wifiLevel(WIFI_LEVEL_3).asCommand()).isEqualTo(" -e wifi show -e level 3")
    assertThat(network().wifiLevel(WIFI_LEVEL_4).asCommand()).isEqualTo(" -e wifi show -e level 4")
  }

  @Test fun mobile() {
    assertThat(network().mobile(true).asCommand()).isEqualTo(" -e mobile show")
    assertThat(network().mobile(false).asCommand()).isEqualTo(" -e mobile false")
  }

  @Test fun mobileDataType() {
    assertThat(network().mobileDataType(MOBILE_DATA_TYPE_1X).asCommand()).isEqualTo(" -e mobile show -e datatype 1x")
    assertThat(network().mobileDataType(MOBILE_DATA_TYPE_3G).asCommand()).isEqualTo(" -e mobile show -e datatype 3g")
    assertThat(network().mobileDataType(MOBILE_DATA_TYPE_4G).asCommand()).isEqualTo(" -e mobile show -e datatype 4g")
    assertThat(network().mobileDataType(MOBILE_DATA_TYPE_E).asCommand()).isEqualTo(" -e mobile show -e datatype e")
    assertThat(network().mobileDataType(MOBILE_DATA_TYPE_G).asCommand()).isEqualTo(" -e mobile show -e datatype g")
    assertThat(network().mobileDataType(MOBILE_DATA_TYPE_H).asCommand()).isEqualTo(" -e mobile show -e datatype h")
    assertThat(network().mobileDataType(MOBILE_DATA_TYPE_LTE).asCommand()).isEqualTo(" -e mobile show -e datatype lte")
    assertThat(network().mobileDataType(MOBILE_DATA_TYPE_ROAM).asCommand()).isEqualTo(" -e mobile show -e datatype roam")
    assertThat(network().mobileDataType(MOBILE_DATA_TYPE_HIDDEN).asCommand()).isEqualTo(" -e mobile false -e datatype hidden")
  }

  @Test fun mobileLevel() {
    assertThat(network().mobileLevel(MOBILE_LEVEL_NULL).asCommand()).isEqualTo(" -e mobile show -e level null")
    assertThat(network().mobileLevel(MOBILE_LEVEL_0).asCommand()).isEqualTo(" -e mobile show -e level 0")
    assertThat(network().mobileLevel(MOBILE_LEVEL_1).asCommand()).isEqualTo(" -e mobile show -e level 1")
    assertThat(network().mobileLevel(MOBILE_LEVEL_2).asCommand()).isEqualTo(" -e mobile show -e level 2")
    assertThat(network().mobileLevel(MOBILE_LEVEL_3).asCommand()).isEqualTo(" -e mobile show -e level 3")
    assertThat(network().mobileLevel(MOBILE_LEVEL_4).asCommand()).isEqualTo(" -e mobile show -e level 4")
  }

  @Test fun carriernetworkchange() {
    assertThat(network().carriernetworkchange(true).asCommand()).isEqualTo(" -e carriernetworkchange show")
    assertThat(network().carriernetworkchange(false).asCommand()).isEqualTo(" -e carriernetworkchange false")
  }

  @Test fun invalidSim() {
    val command = network()

    assertThrows<IllegalArgumentException> {
      command.sims(0)
    }.hasMessage("Network sims should be between 1 and 8")

    assertThrows<IllegalArgumentException> {
      command.sims(9)
    }.hasMessage("Network sims should be between 1 and 8")
  }

  @Test fun sims() {
    assertThat(network().sims(1).asCommand()).isEqualTo(" -e sims 1")
    assertThat(network().sims(2).asCommand()).isEqualTo(" -e sims 2")
    assertThat(network().sims(3).asCommand()).isEqualTo(" -e sims 3")
    assertThat(network().sims(4).asCommand()).isEqualTo(" -e sims 4")
    assertThat(network().sims(5).asCommand()).isEqualTo(" -e sims 5")
    assertThat(network().sims(6).asCommand()).isEqualTo(" -e sims 6")
    assertThat(network().sims(7).asCommand()).isEqualTo(" -e sims 7")
    assertThat(network().sims(8).asCommand()).isEqualTo(" -e sims 8")
  }

  @Test fun nosim() {
    assertThat(network().nosim(true).asCommand()).isEqualTo(" -e nosim show")
    assertThat(network().nosim(false).asCommand()).isEqualTo(" -e nosim false")
  }

  @Test fun wifiLevels() {
    assertThat(WifiLevel.values()).containsExactly(WIFI_LEVEL_NULL, WIFI_LEVEL_0, WIFI_LEVEL_1, WIFI_LEVEL_2, WIFI_LEVEL_3, WIFI_LEVEL_4)
  }

  @Test fun mobileDataTypes() {
    assertThat(MobileDataType.values()).containsExactly(MOBILE_DATA_TYPE_1X, MOBILE_DATA_TYPE_3G, MOBILE_DATA_TYPE_4G, MOBILE_DATA_TYPE_E, MOBILE_DATA_TYPE_G, MOBILE_DATA_TYPE_H, MOBILE_DATA_TYPE_LTE, MOBILE_DATA_TYPE_ROAM, MOBILE_DATA_TYPE_HIDDEN)
  }

  @Test fun mobileLevels() {
    assertThat(MobileLevel.values()).containsExactly(MOBILE_LEVEL_NULL, MOBILE_LEVEL_0, MOBILE_LEVEL_1, MOBILE_LEVEL_2, MOBILE_LEVEL_3, MOBILE_LEVEL_4)
  }
}
