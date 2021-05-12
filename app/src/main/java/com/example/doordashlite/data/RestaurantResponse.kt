package com.example.doordashlite.data


data class RestaurantResponse (
        val phone_number: String?,
        val yelp_review_count: Long,
        val is_consumer_subscription_eligible: Boolean,
        val offers_delivery: Boolean,
        val max_order_size: Any? = null,
        val delivery_fee: Long,
        val max_composite_score: Long,
        val provides_external_courier_tracking: Boolean,
        val id: Long,
        val average_rating: Double,
        val tags: List<String?>,
        val delivery_radius: Long,
        val inflation_rate: Long,
        val menus: List<Menu>,
        val show_store_menu_header_photo: Boolean,
        val composite_score: Long,
        val fulfills_own_deliveries: Boolean,
        val offers_pickup: Boolean,
        val number_of_ratings: Long,
        val status_type: String?,
        val is_only_catering: Boolean,
        val status: String?,
        val delivery_fee_details: DeliveryFeeDetails,
        val object_type: String?,
        val description: String?,
        val business: Business,
        val yelp_biz_id: String?,
        val asap_time: Long,
        val should_show_store_logo: Boolean,
        val yelp_rating: Float,
        val extra_sos_delivery_fee: Long,
        val business_id: Long,
        val special_instructions_max_length: Any? = null,
        val cover_img_url: String?,
        val address: Address,
        val price_range: Long,
        val slug: String?,
        val show_suggested_items: Boolean,
        val name: String?,
        val is_newly_added: Boolean,
        val is_good_for_group_orders: Boolean,
        val service_rate: Long,
        val merchant_promotions: List<MerchantPromotion>,
        val header_image_url: String? = null
)

data class Address (
        val city: String?,
        val subpremise: String?,
        val id: Long,
        val printable_address: String?,
        val state: String?,
        val street: String?,
        val country: String?,
        val lat: Double,
        val lng: Double,
        val shortname: String?,
        val zip_code: String?
)

data class Business (
        val business_vertical: Any? = null,
        val id: Long,
        val name: String?
)

data class DeliveryFeeDetails (
        val final_fee: Fee,
        val discount: Discount,
        val surge_fee: Fee,
        val original_fee: Fee
)

data class Discount (
        val description: String?,
        val source_type: String?,
        val text: String?,
        val discount_type: String?,
        val amount: Amount,
        val min_subtotal: Amount
)

data class Amount (
        val currency: String?,
        val display_string: String?,
        val unit_amount: Long? = null,
        val decimal_places: Long? = null
)

data class Fee (
        val display_string: String?,
        val unit_amount: Long
)

data class Menu (
        val status: String?,
        val menu_version: Long,
        val subtitle: String?,
        val name: String?,
        val open_hours: List<List<OpenHour>>,
        val is_business_enabled: Any? = null,
        val is_catering: Boolean,
        val id: Long,
        val status_type: String?
)

data class OpenHour (
        val hour: Long,
        val minute: Long
)

data class MerchantPromotion (
        val minimum_subtotal_monetary_fields: Amount,
        val delivery_fee: Long,
        val delivery_fee_monetary_fields: Amount,
        val minimum_subtotal: String? = null,
        val new_store_customers_only: Boolean,
        val id: Long
)
