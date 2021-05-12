package com.example.doordashlite.data

import com.squareup.moshi.Json

data class RestaurantResponse (
        @Json(name = "phone_number")
        val phoneNumber: String,

        @Json(name = "yelp_review_count")
        val yelpReviewCount: Long,

        @Json(name = "is_consumer_subscription_eligible")
        val isConsumerSubscriptionEligible: Boolean,

        @Json(name = "offers_delivery")
        val offersDelivery: Boolean,

        @Json(name = "max_order_size")
        val maxOrderSize: Any? = null,

        @Json(name = "delivery_fee")
        val deliveryFee: Long,

        @Json(name = "max_composite_score")
        val maxCompositeScore: Long,

        @Json(name = "provides_external_courier_tracking")
        val providesExternalCourierTracking: Boolean,

        val id: Long,

        @Json(name = "average_rating")
        val averageRating: Double,

        val tags: List<String>,

        @Json(name = "delivery_radius")
        val deliveryRadius: Long,

        @Json(name = "inflation_rate")
        val inflationRate: Long,

        val menus: List<Menu>,

        @Json(name = "show_store_menu_header_photo")
        val showStoreMenuHeaderPhoto: Boolean,

        @Json(name = "composite_score")
        val compositeScore: Long,

        @Json(name = "fulfills_own_deliveries")
        val fulfillsOwnDeliveries: Boolean,

        @Json(name = "offers_pickup")
        val offersPickup: Boolean,

        @Json(name = "number_of_ratings")
        val numberOfRatings: Long,

        @Json(name = "status_type")
        val statusType: String,

        @Json(name = "is_only_catering")
        val isOnlyCatering: Boolean,

        val status: String,

        @Json(name = "delivery_fee_details")
        val deliveryFeeDetails: DeliveryFeeDetails,

        @Json(name = "object_type")
        val objectType: String,

        val description: String,
        val business: Business,

        @Json(name = "yelp_biz_id")
        val yelpBizID: String,

        @Json(name = "asap_time")
        val asapTime: Long,

        @Json(name = "should_show_store_logo")
        val shouldShowStoreLogo: Boolean,

        @Json(name = "yelp_rating")
        val yelpRating: Long,

        @Json(name = "extra_sos_delivery_fee")
        val extraSosDeliveryFee: Long,

        @Json(name = "business_id")
        val businessID: Long,

        @Json(name = "special_instructions_max_length")
        val specialInstructionsMaxLength: Any? = null,

        @Json(name = "cover_img_url")
        val coverImgURL: String,

        val address: Address,

        @Json(name = "price_range")
        val priceRange: Long,

        val slug: String,

        @Json(name = "show_suggested_items")
        val showSuggestedItems: Boolean,

        val name: String,

        @Json(name = "is_newly_added")
        val isNewlyAdded: Boolean,

        @Json(name = "is_good_for_group_orders")
        val isGoodForGroupOrders: Boolean,

        @Json(name = "service_rate")
        val serviceRate: Long,

        @Json(name = "merchant_promotions")
        val merchantPromotions: List<MerchantPromotion>,

        @Json(name = "header_image_url")
        val headerImageURL: Any? = null
)

data class Address (
        val city: String,
        val subpremise: String,
        val id: Long,

        @Json(name = "printable_address")
        val printableAddress: String,

        val state: String,
        val street: String,
        val country: String,
        val lat: Double,
        val lng: Double,
        val shortname: String,

        @Json(name = "zip_code")
        val zipCode: String
)

data class Business (
        @Json(name = "business_vertical")
        val businessVertical: Any? = null,

        val id: Long,
        val name: String
)

data class DeliveryFeeDetails (
        @Json(name = "final_fee")
        val finalFee: Fee,

        val discount: Discount,

        @Json(name = "surge_fee")
        val surgeFee: Fee,

        @Json(name = "original_fee")
        val originalFee: Fee
)

data class Discount (
        val description: String,

        @Json(name = "source_type")
        val sourceType: String,

        val text: String,

        @Json(name = "discount_type")
        val discountType: String,

        val amount: Amount,

        @Json(name = "min_subtotal")
        val minSubtotal: Amount
)

data class Amount (
        val currency: String,

        @Json(name = "display_string")
        val displayString: String,

        @Json(name = "unit_amount")
        val unitAmount: Long? = null,

        @Json(name = "decimal_places")
        val decimalPlaces: Long? = null
)

data class Fee (
        @Json(name = "display_string")
        val displayString: String,

        @Json(name = "unit_amount")
        val unitAmount: Long
)

data class Menu (
        val status: String,

        @Json(name = "menu_version")
        val menuVersion: Long,

        val subtitle: String,
        val name: String,

        @Json(name = "open_hours")
        val openHours: List<List<OpenHour>>,

        @Json(name = "is_business_enabled")
        val isBusinessEnabled: Any? = null,

        @Json(name = "is_catering")
        val isCatering: Boolean,

        val id: Long,

        @Json(name = "status_type")
        val statusType: String
)

data class OpenHour (
        val hour: Long,
        val minute: Long
)

data class MerchantPromotion (
        @Json(name = "minimum_subtotal_monetary_fields")
        val minimumSubtotalMonetaryFields: Amount,

        @Json(name = "delivery_fee")
        val deliveryFee: Long,

        @Json(name = "delivery_fee_monetary_fields")
        val deliveryFeeMonetaryFields: Amount,

        @Json(name = "minimum_subtotal")
        val minimumSubtotal: Any? = null,

        @Json(name = "new_store_customers_only")
        val newStoreCustomersOnly: Boolean,

        val id: Long
)
