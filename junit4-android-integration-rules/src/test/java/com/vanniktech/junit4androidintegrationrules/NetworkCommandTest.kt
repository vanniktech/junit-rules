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
import org.junit.Assert.assertEquals
import org.junit.Test

class NetworkCommandTest {
  @Test fun name() {
    assertEquals("network", network().name)
  }

  @Test fun empty() {
    assertEquals(true, network().asCommand().isEmpty())
  }

  @Test fun airplane() {
    assertEquals(" -e airplane show", network().airplane(true).asCommand())
    assertEquals(" -e airplane false", network().airplane(false).asCommand())
  }

  @Test fun fully() {
    assertEquals(" -e fully true", network().fully(true).asCommand())
    assertEquals(" -e fully false", network().fully(false).asCommand())
  }

  @Test fun wifi() {
    assertEquals(" -e wifi show", network().wifi(true).asCommand())
    assertEquals(" -e wifi false", network().wifi(false).asCommand())
  }

  @Test fun wifiLevel() {
    assertEquals(" -e wifi show -e level null", network().wifiLevel(WIFI_LEVEL_NULL).asCommand())
    assertEquals(" -e wifi show -e level 0", network().wifiLevel(WIFI_LEVEL_0).asCommand())
    assertEquals(" -e wifi show -e level 1", network().wifiLevel(WIFI_LEVEL_1).asCommand())
    assertEquals(" -e wifi show -e level 2", network().wifiLevel(WIFI_LEVEL_2).asCommand())
    assertEquals(" -e wifi show -e level 3", network().wifiLevel(WIFI_LEVEL_3).asCommand())
    assertEquals(" -e wifi show -e level 4", network().wifiLevel(WIFI_LEVEL_4).asCommand())
  }

  @Test fun mobile() {
    assertEquals(" -e mobile show", network().mobile(true).asCommand())
    assertEquals(" -e mobile false", network().mobile(false).asCommand())
  }

  @Test fun mobileDataType() {
    assertEquals(" -e mobile show -e datatype 1x", network().mobileDataType(MOBILE_DATA_TYPE_1X).asCommand())
    assertEquals(" -e mobile show -e datatype 3g", network().mobileDataType(MOBILE_DATA_TYPE_3G).asCommand())
    assertEquals(" -e mobile show -e datatype 4g", network().mobileDataType(MOBILE_DATA_TYPE_4G).asCommand())
    assertEquals(" -e mobile show -e datatype e", network().mobileDataType(MOBILE_DATA_TYPE_E).asCommand())
    assertEquals(" -e mobile show -e datatype g", network().mobileDataType(MOBILE_DATA_TYPE_G).asCommand())
    assertEquals(" -e mobile show -e datatype h", network().mobileDataType(MOBILE_DATA_TYPE_H).asCommand())
    assertEquals(" -e mobile show -e datatype lte", network().mobileDataType(MOBILE_DATA_TYPE_LTE).asCommand())
    assertEquals(" -e mobile show -e datatype roam", network().mobileDataType(MOBILE_DATA_TYPE_ROAM).asCommand())
    assertEquals(" -e mobile false -e datatype hidden", network().mobileDataType(MOBILE_DATA_TYPE_HIDDEN).asCommand())
  }

  @Test fun mobileLevel() {
    assertEquals(" -e mobile show -e level null", network().mobileLevel(MOBILE_LEVEL_NULL).asCommand())
    assertEquals(" -e mobile show -e level 0", network().mobileLevel(MOBILE_LEVEL_0).asCommand())
    assertEquals(" -e mobile show -e level 1", network().mobileLevel(MOBILE_LEVEL_1).asCommand())
    assertEquals(" -e mobile show -e level 2", network().mobileLevel(MOBILE_LEVEL_2).asCommand())
    assertEquals(" -e mobile show -e level 3", network().mobileLevel(MOBILE_LEVEL_3).asCommand())
    assertEquals(" -e mobile show -e level 4", network().mobileLevel(MOBILE_LEVEL_4).asCommand())
  }

  @Test fun carriernetworkchange() {
    assertEquals(" -e carriernetworkchange show", network().carriernetworkchange(true).asCommand())
    assertEquals(" -e carriernetworkchange false", network().carriernetworkchange(false).asCommand())
  }

  @Test fun invalidSim() {
    val command = network()

    assertThrows<IllegalArgumentException>(message = "Network sims should be between 1 and 8") {
      command.sims(0)
    }

    assertThrows<IllegalArgumentException>(message = "Network sims should be between 1 and 8") {
      command.sims(9)
    }
  }

  @Test fun sims() {
    assertEquals(" -e sims 1", network().sims(1).asCommand())
    assertEquals(" -e sims 2", network().sims(2).asCommand())
    assertEquals(" -e sims 3", network().sims(3).asCommand())
    assertEquals(" -e sims 4", network().sims(4).asCommand())
    assertEquals(" -e sims 5", network().sims(5).asCommand())
    assertEquals(" -e sims 6", network().sims(6).asCommand())
    assertEquals(" -e sims 7", network().sims(7).asCommand())
    assertEquals(" -e sims 8", network().sims(8).asCommand())
  }

  @Test fun nosim() {
    assertEquals(" -e nosim show", network().nosim(true).asCommand())
    assertEquals(" -e nosim false", network().nosim(false).asCommand())
  }

  @Test fun wifiLevels() {
    assertEquals(listOf(WIFI_LEVEL_NULL, WIFI_LEVEL_0, WIFI_LEVEL_1, WIFI_LEVEL_2, WIFI_LEVEL_3, WIFI_LEVEL_4), WifiLevel.values().toList())
  }

  @Test fun mobileDataTypes() {
    assertEquals(listOf(MOBILE_DATA_TYPE_1X, MOBILE_DATA_TYPE_3G, MOBILE_DATA_TYPE_4G, MOBILE_DATA_TYPE_E, MOBILE_DATA_TYPE_G, MOBILE_DATA_TYPE_H, MOBILE_DATA_TYPE_LTE, MOBILE_DATA_TYPE_ROAM, MOBILE_DATA_TYPE_HIDDEN), MobileDataType.values().toList())
  }

  @Test fun mobileLevels() {
    assertEquals(listOf(MOBILE_LEVEL_NULL, MOBILE_LEVEL_0, MOBILE_LEVEL_1, MOBILE_LEVEL_2, MOBILE_LEVEL_3, MOBILE_LEVEL_4), MobileLevel.values().toList())
  }
}
