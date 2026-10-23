package app.spinline.embed

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Assert.assertTrue
import org.junit.Test

class SpinlineEventTest {
    @Test
    fun parsesResult() {
        val e = SpinlineEvent.parse("""{"source":"spinline","type":"result","game":"LUDO","won":true,"net":40}""")!!
        assertEquals("result", e.type)
        assertEquals("LUDO", e.game)
        assertTrue(e.won)
        assertEquals(40, e.net)
    }

    @Test
    fun rejectsOtherSendersAndMalformed() {
        assertNull(SpinlineEvent.parse("""{"source":"other","type":"result"}"""))
        assertNull(SpinlineEvent.parse("""{"source":"spinline"}"""))
        assertNull(SpinlineEvent.parse("not json"))
    }

    @Test
    fun exposesErrorFields() {
        val e = SpinlineEvent.parse("""{"source":"spinline","type":"error","code":"LAUNCH_USED","message":"used"}""")!!
        assertEquals("LAUNCH_USED", e.code)
        assertEquals("used", e.message)
    }
}
