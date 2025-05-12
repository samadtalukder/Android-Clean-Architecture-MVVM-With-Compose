package com.samad_talukder.mvvmcompose.ui.common.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.samad_talukder.mvvmcompose.R

val Medium = FontWeight.Medium
val Regular = FontWeight.Normal

val BodyLargeLineHeight = 24.0.sp
val BodyLargeSize = 16.sp
val BodyLargeTracking = 0.5.sp
val BodyLargeWeight = Regular
val BodyMediumLineHeight = 20.0.sp
val BodyMediumSize = 14.sp
val BodyMediumTracking = 0.2.sp
val BodyMediumWeight = Regular
val BodySmallLineHeight = 16.0.sp
val BodySmallSize = 12.sp
val BodySmallTracking = 0.4.sp
val BodySmallWeight = Regular

val DisplayMediumLineHeight = 52.0.sp
val DisplayMediumSize = 45.sp
val DisplayMediumTracking = 0.0.sp
val DisplayMediumWeight = Regular
val DisplaySmallLineHeight = 44.0.sp
val DisplaySmallSize = 36.sp
val DisplaySmallTracking = 0.0.sp
val DisplaySmallWeight = Regular

val HeadlineLargeLineHeight = 40.0.sp
val HeadlineLargeSize = 32.sp
val HeadlineLargeTracking = 0.0.sp
val HeadlineLargeWeight = Regular
val HeadlineMediumLineHeight = 36.0.sp
val HeadlineMediumSize = 28.sp
val HeadlineMediumTracking = 0.0.sp
val HeadlineMediumWeight = Regular
val HeadlineSmallLineHeight = 32.0.sp
val HeadlineSmallSize = 24.sp
val HeadlineSmallTracking = 0.0.sp
val HeadlineSmallWeight = Regular

val LabelLargeLineHeight = 20.0.sp
val LabelLargeSize = 14.sp
val LabelLargeTracking = 0.1.sp
val LabelLargeWeight = Medium
val LabelMediumLineHeight = 16.0.sp
val LabelMediumSize = 12.sp
val LabelMediumTracking = 0.5.sp
val LabelMediumWeight = Medium
val LabelSmallLineHeight = 16.0.sp
val LabelSmallSize = 11.sp
val LabelSmallTracking = 0.5.sp
val LabelSmallWeight = Medium

val TitleLargeLineHeight = 28.0.sp
val TitleLargeSize = 22.sp
val TitleLargeTracking = 0.0.sp
val TitleLargeWeight = Regular
val TitleMediumLineHeight = 24.0.sp
val TitleMediumSize = 16.sp
val TitleMediumTracking = 0.2.sp
val TitleMediumWeight = Medium
val TitleSmallLineHeight = 20.0.sp
val TitleSmallSize = 14.sp
val TitleSmallTracking = 0.1.sp
val TitleSmallWeight = Medium

private val SenFont = FontFamily(
    Font(R.font.sen_regular, FontWeight.Normal),
    Font(R.font.sen_medium, FontWeight.Medium),
    Font(R.font.sen_semi_bold, FontWeight.SemiBold),
    Font(R.font.sen_bold, FontWeight.Bold)
)

val SenTypography = Typography(

    displayLarge = TextStyle(
        fontFamily = SenFont,
        fontWeight = Regular,
        fontSize = 57.sp,
        lineHeight = 64.sp,
        letterSpacing = 0.sp,
    ),
    displayMedium = TextStyle(
        fontFamily = SenFont,
        fontWeight = DisplayMediumWeight,
        fontSize = DisplayMediumSize,
        lineHeight = DisplayMediumLineHeight,
        letterSpacing = DisplayMediumTracking,
    ),
    displaySmall = TextStyle(
        fontFamily = SenFont,
        fontWeight = DisplaySmallWeight,
        fontSize = DisplaySmallSize,
        lineHeight = DisplaySmallLineHeight,
        letterSpacing = DisplaySmallTracking,
    ),
    headlineLarge = TextStyle(
        fontFamily = SenFont,
        fontWeight = HeadlineLargeWeight,
        fontSize = HeadlineLargeSize,
        lineHeight = HeadlineLargeLineHeight,
        letterSpacing = HeadlineLargeTracking,
    ),
    headlineMedium = TextStyle(
        fontFamily = SenFont,
        fontWeight = HeadlineMediumWeight,
        fontSize = HeadlineMediumSize,
        lineHeight = HeadlineMediumLineHeight,
        letterSpacing = HeadlineMediumTracking,
    ),
    headlineSmall = TextStyle(
        fontFamily = SenFont,
        fontWeight = HeadlineSmallWeight,
        fontSize = HeadlineSmallSize,
        lineHeight = HeadlineSmallLineHeight,
        letterSpacing = HeadlineSmallTracking,
    ),
    titleLarge = TextStyle(
        fontFamily = SenFont,
        fontWeight = TitleLargeWeight,
        fontSize = TitleLargeSize,
        lineHeight = TitleLargeLineHeight,
        letterSpacing = TitleLargeTracking,
    ),
    titleMedium = TextStyle(
        fontFamily = SenFont,
        fontWeight = TitleMediumWeight,
        fontSize = TitleMediumSize,
        lineHeight = TitleMediumLineHeight,
        letterSpacing = TitleMediumTracking,
    ),
    titleSmall = TextStyle(
        fontFamily = SenFont,
        fontWeight = TitleSmallWeight,
        fontSize = TitleSmallSize,
        lineHeight = TitleSmallLineHeight,
        letterSpacing = TitleSmallTracking,
    ),
    bodyLarge = TextStyle(
        fontFamily = SenFont,
        fontWeight = BodyLargeWeight,
        fontSize = BodyLargeSize,
        lineHeight = BodyLargeLineHeight,
        letterSpacing = BodyLargeTracking,
    ),
    bodyMedium = TextStyle(
        fontFamily = SenFont,
        fontWeight = BodyMediumWeight,
        fontSize = BodyMediumSize,
        lineHeight = BodyMediumLineHeight,
        letterSpacing = BodyMediumTracking,
    ),
    bodySmall = TextStyle(
        fontFamily = SenFont,
        fontWeight = BodySmallWeight,
        fontSize = BodySmallSize,
        lineHeight = BodySmallLineHeight,
        letterSpacing = BodySmallTracking,
    ),
    labelLarge = TextStyle(
        fontFamily = SenFont,
        fontWeight = LabelLargeWeight,
        fontSize = LabelLargeSize,
        lineHeight = LabelLargeLineHeight,
        letterSpacing = LabelLargeTracking,
    ),
    labelMedium = TextStyle(
        fontFamily = SenFont,
        fontWeight = LabelMediumWeight,
        fontSize = LabelMediumSize,
        lineHeight = LabelMediumLineHeight,
        letterSpacing = LabelMediumTracking,
    ),
    labelSmall = TextStyle(
        fontFamily = SenFont,
        fontWeight = LabelSmallWeight,
        fontSize = LabelSmallSize,
        lineHeight = LabelSmallLineHeight,
        letterSpacing = LabelSmallTracking,
    )
)



