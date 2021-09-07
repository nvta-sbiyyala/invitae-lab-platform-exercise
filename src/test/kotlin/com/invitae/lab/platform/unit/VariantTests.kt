package com.invitae.lab.platform.unit

import com.invitae.lab.platform.domain.Variant
import io.mockk.junit5.MockKExtension
import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(MockKExtension::class)
class VariantTests {
    val variantPGAM4: Variant = Variant(
        "PGAM4",
        "NG_013224.2:g.(?_4960)_(103567_105489)dup,NC_000023.11:g.(?_77910656)_(78009263_78011185)dup",
        "NG_013224.2,NC_000023.11"
    )

    @DisplayName("createVariant")
    @Test
    internal fun `successfully create Variant`() {
        assertThat(variantPGAM4.gene).isEqualTo("PGAM4")
    }
}