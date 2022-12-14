package com.example.gads_androidx_preference_library

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.navigation.fragment.NavHostFragment
import androidx.preference.MultiSelectListPreference
import androidx.preference.Preference
import androidx.preference.PreferenceCategory
import androidx.preference.PreferenceFragmentCompat


class AccountSettingsFragment : PreferenceFragmentCompat() {


    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
//        setPreferencesFromResource(R.xml.account_settings, rootKey)

        // writing the original UI of this account settings fragment in just kotlin and not xml

        // step1
        // define all the preference objects with appropriate properties
        val publicinfoPref = MultiSelectListPreference(requireContext())
        publicinfoPref.entries = resources.getStringArray(R.array.entries_public_info)
        publicinfoPref.entryValues = resources.getStringArray(R.array.values_public_info)

        publicinfoPref.key = getString(R.string.key_public_info)
        publicinfoPref.title = getString(R.string.title_public_info)
        publicinfoPref.isIconSpaceReserved = false

        val logOutPref = Preference(requireContext())
        logOutPref.key = getString(R.string.key_log_out)
        logOutPref.title = getString(R.string.title_log_out)
        logOutPref.isIconSpaceReserved = false

        val deleteAccPref = Preference(requireContext())
        deleteAccPref.key = getString(R.string.key_delete_account)
        deleteAccPref.summary = getString(R.string.summary_delete_account)
        deleteAccPref.title = getString(R.string.title_delete_account)
        deleteAccPref.icon = ResourcesCompat.getDrawable(resources, android.R.drawable.ic_menu_delete, null)

        val privacyCategory = PreferenceCategory(requireContext())
        privacyCategory.title = getString(R.string.title_privacy)
        privacyCategory.isIconSpaceReserved = false

        val securityCategory = PreferenceCategory(requireContext())
        securityCategory.title = getString(R.string.title_security)
        securityCategory.isIconSpaceReserved = false

        val prefScreen = preferenceManager.createPreferenceScreen(requireContext())

        // step2
        // add all preference objects in hierarchy

        prefScreen.addPreference(privacyCategory)
        prefScreen.addPreference(securityCategory)

        privacyCategory.addPreference(publicinfoPref)

        securityCategory.addPreference(logOutPref)
        securityCategory.addPreference(deleteAccPref)

        // step 3
        // set the preference screen
        preferenceScreen = prefScreen

    }
}
